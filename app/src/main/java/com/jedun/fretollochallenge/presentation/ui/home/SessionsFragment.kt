package com.jedun.fretollochallenge.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jedun.fretollochallenge.databinding.FragmentSessionsBinding
import com.jedun.fretollochallenge.presentation.ui.home.sessionrecycleradapter.SessionListAdapter
import com.jedun.fretollochallenge.presentation.ui.home.states.SessionStateEvent
import com.jedun.fretollochallenge.presentation.util.showDialog
import dagger.hilt.android.AndroidEntryPoint

const val FRAGMENT_RUNNING = "sessions_fragment"

@AndroidEntryPoint
class SessionsFragment : Fragment() {

    private val sessionsViewModel: SessionsViewModel by activityViewModels()

    private var _binding: FragmentSessionsBinding? = null
    private lateinit var sessionRecyclerAdapter: SessionListAdapter
    private lateinit var sessionsRecyclerView: RecyclerView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    var fragmentIsAlreadyRunning = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
          Network calls should only be made when the fragment is newly launched.
          In case it goes through configuration changes, it should not make the call.
         */
        if (savedInstanceState != null) {
            fragmentIsAlreadyRunning = savedInstanceState.getBoolean(FRAGMENT_RUNNING)
        } else {
            if (!fragmentIsAlreadyRunning) {
                sessionsViewModel.getSessions()
            }
        }
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSessionsBinding.inflate(inflater, container, false)

        initializeVariables()

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpEvents()

        subsScribeObservables()
    }


    private fun setUpEvents() {
        binding.reloadButton.setOnClickListener {
            sessionsViewModel.setEventState(SessionStateEvent.GetSessions)
        }

        binding.paymentMethodFragmentSwipeRefresh.setOnRefreshListener {
            sessionsViewModel.setEventState(SessionStateEvent.GetSessions)
        }
    }


    private fun subsScribeObservables() {
        sessionsViewModel.sessionViewStateObservable.observe(viewLifecycleOwner, {

            if (it.snackError.getContentIfNotHandled() != null && it.snackError.peekContent()
                    .isNotEmpty()
            )
                Snackbar.make(
                    binding.fragmentSessionRecyclerView,
                    it.snackError.peekContent(),
                    Snackbar.LENGTH_SHORT
                ).show()



            binding.paymentMethodFragmentSwipeRefresh.isRefreshing = it.isLoading
            sessionRecyclerAdapter.submitList(it.sessions.reversed())
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(FRAGMENT_RUNNING, true)
    }


    private fun initializeVariables() {
        binding.viewmodel = sessionsViewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
        toolbar = binding.fragmentSessionToolBar
        sessionsRecyclerView = binding.fragmentSessionRecyclerView
        sessionRecyclerAdapter = SessionListAdapter()
        sessionsRecyclerView.adapter = sessionRecyclerAdapter
        toolbar.title = "Exercises"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}