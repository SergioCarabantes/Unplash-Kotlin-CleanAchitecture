package com.sergio.unsplash.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.pagination(offset: Int = 5, loadMore: (page: Int) -> Unit): RecyclerView.OnScrollListener {
    return object : RecyclerView.OnScrollListener() {
        private var loading = true
        private var previousTotal = 0
        private var nextPage = 2
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            (recyclerView.layoutManager as? LinearLayoutManager)?.apply {
                val visibleItemCount = childCount
                val totalItemCount = itemCount
                val firstVisibleItem = findFirstVisibleItemPosition()

                if (loading && totalItemCount > previousTotal) {
                        loading = false
                        previousTotal = totalItemCount
                }

                if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + offset)) {
                    loadMore(nextPage++)
                    loading = true
                }
            }
        }
    }
}
