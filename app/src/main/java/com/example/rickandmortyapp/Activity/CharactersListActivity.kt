package com.example.rickandmortyapp.Activity

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rickandmortyapp.adapter.RickPagedAdapter
import com.example.rickandmortyapp.databinding.ActivityCharactersListBinding
import com.example.rickandmortyapp.viewmodel.RickViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharactersListBinding
    private lateinit var mAdapter: RickPagedAdapter
    private val viewModel: RickViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        initSearchView()
        loadingData()
    }

    private fun initUI() {
        mAdapter = RickPagedAdapter()
        binding.rvCharacters.apply {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->
                mAdapter.submitData(pagingData)
            }
        }
    }

    private fun initSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    filterCharacters(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    filterCharacters(it)
                }
                return true
            }
        })
    }

    private fun filterCharacters(query: String) {
        lifecycleScope.launch {
            viewModel.getFilteredCharacters(query).collect { pagingData ->
                mAdapter.submitData(pagingData)
            }
        }
    }
}