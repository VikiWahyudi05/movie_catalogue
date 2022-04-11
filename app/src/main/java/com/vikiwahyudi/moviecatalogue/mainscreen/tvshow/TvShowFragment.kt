package com.vikiwahyudi.moviecatalogue.mainscreen.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vikiwahyudi.core.data.Resource
import com.vikiwahyudi.moviecatalogue.ui.TvShowAdapter
import com.vikiwahyudi.moviecatalogue.R
import com.vikiwahyudi.moviecatalogue.databinding.FragmentTvShowBinding
import com.vikiwahyudi.moviecatalogue.detail.tvshow.TvShowDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvShowFragment : Fragment() {

    private val tvShowViewModel: TvShowViewModel by viewModel()

    private var _fragmentTvShowBinding: FragmentTvShowBinding? = null
    val fragmentTvShowBinding get() = _fragmentTvShowBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null) {
            val tvShowAdapter = TvShowAdapter()
            tvShowAdapter.onItemClick = { selectedData ->
                val moveIntent = Intent(requireActivity(), TvShowDetailActivity::class.java)
                moveIntent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW_ID, selectedData.id)
                startActivity(moveIntent)
            }

            tvShowViewModel.tvShows.observe(viewLifecycleOwner) { tvShows ->
                if (tvShows != null) {
                    when (tvShows) {
                        is Resource.Loading -> showProgressBar(true)
                        is Resource.Success -> {
                            showProgressBar(false)
                            tvShowAdapter.setData(tvShows.data)
                        }
                        is Resource.Error -> {
                            showProgressBar(false)
                            fragmentTvShowBinding.viewError.root.visibility = View.VISIBLE
                            fragmentTvShowBinding.viewError.tvError.text =
                                tvShows.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentTvShowBinding = null
    }

    private fun showProgressBar(state: Boolean) {
        fragmentTvShowBinding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }
}