package com.example.rentateamapp.presenter.users_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rentateamapp.data.models.User
import com.example.rentateamapp.databinding.ItemUserBinding
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class UserAdapter @AssistedInject constructor(@Assisted private val onClick: (User) -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {

    private val diffUtil = AsyncListDiffer(this, UserCallback())

    fun submit(users: List<User>) {
        diffUtil.submitList(users)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserHolder(ItemUserBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(diffUtil.currentList[position])
    }

    override fun getItemCount(): Int = diffUtil.currentList.size

    inner class UserHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var user: User
        fun bind(user: User) {
            this.user = user
            with(binding) {
                cvItem.setOnClickListener { onClick(user) }
                tvName.text = user.firstName
                tvSecondName.text = user.lastName
            }
        }
    }

    class UserCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    @AssistedFactory
    interface UserAdapterFactory {
        fun createAdapter(onClick: (User) -> Unit): UserAdapter
    }
}