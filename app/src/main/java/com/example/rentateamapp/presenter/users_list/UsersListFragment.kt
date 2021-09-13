package com.example.rentateamapp.presenter.users_list

import android.os.Bundle
import android.view.View
import com.example.rentateamapp.databinding.FragmentUsersListBinding
import com.example.rentateamapp.presenter.core.BaseFragment
import com.example.rentateamapp.presenter.gone
import com.example.rentateamapp.presenter.visible
import javax.inject.Inject

class UsersListFragment : BaseFragment<FragmentUsersListBinding, UsersListViewModel>(
    FragmentUsersListBinding::inflate
) {

    @Inject
    lateinit var adapterFactory: UserAdapter.UserAdapterFactory

    @Inject
    lateinit var decorationFactory: ItemDecorationFactory

    private lateinit var adapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupLiveDataObserving()

        viewModel.loadUsers()
    }

    private fun setupUI() = with(binding) {
        rvUsers.adapter = adapterFactory.createAdapter { user ->
            router.showUserDetailsFragment(requireActivity().supportFragmentManager, user)
        }.also { adapter = it }

        rvUsers.addItemDecoration(
            decorationFactory.create(
                leftMargin = 16,
                rightMargin = 16,
                topMargin = 16,
                bottomMargin = 16
            )
        )

        btnRestart.setOnClickListener {
            viewModel.loadUsers()
        }
    }

    private fun setupLiveDataObserving() = with(viewModel) {
        loadState.observe(viewLifecycleOwner) { state ->
            setupUiModeFromState(state)
        }

        usersList.observe(viewLifecycleOwner) { users ->
            adapter.submit(users)
        }
    }

    private fun setupUiModeFromState(state: UsersListViewModel.State) = with(binding) {
        when (state) {
            UsersListViewModel.State.LOADING -> {
                rvUsers.gone()
                btnRestart.gone()
                pbLoading.visible()
            }
            UsersListViewModel.State.IDLE -> {
                rvUsers.visible()
                btnRestart.gone()
                pbLoading.gone()
            }
            UsersListViewModel.State.ERROR -> {
                rvUsers.gone()
                btnRestart.visible()
                pbLoading.gone()
            }
        }
    }
}