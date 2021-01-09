package dev.hossain.android.catalog.ui.landing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import dev.hossain.android.catalog.R
import dev.hossain.android.catalog.databinding.ListItemFeatureYBinding
import dev.hossain.android.catalog.ui.common.DataBoundListAdapter
import dev.hossain.android.catalog.ui.landing.model.ItemModel

class ManufacturersAdapter(
    private val itemClickCallback: ((ItemModel) -> Unit)?
) : DataBoundListAdapter<ItemModel, ListItemFeatureYBinding>(
    diffCallback = object : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun createBinding(parent: ViewGroup): ListItemFeatureYBinding {
        val binding = DataBindingUtil.inflate<ListItemFeatureYBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_feature_y,
            parent,
            false
        )

        binding.actionDelete.setOnClickListener {
            binding.data?.let {
                itemClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: ListItemFeatureYBinding, item: ItemModel) {
        binding.data = item
    }
}
