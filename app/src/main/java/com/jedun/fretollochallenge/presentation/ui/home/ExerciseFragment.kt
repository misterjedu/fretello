package com.jedun.fretollochallenge.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.jedun.fretollochallenge.R
import com.jedun.fretollochallenge.databinding.FragmentExerciseBinding
import com.jedun.fretollochallenge.presentation.ui.home.exerciserecycleradapter.ExerciseListAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ExerciseFragment : Fragment() {

    private val exerciseArgs by navArgs<ExerciseFragmentArgs>()

    private var _binding: FragmentExerciseBinding? = null
    private val sessionsViewModel: SessionsViewModel by activityViewModels()
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var exerciseRecyclerView: RecyclerView
    private lateinit var exerciseListAdapter: ExerciseListAdapter
    private val binding get() = _binding!!
    private lateinit var sessionName: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExerciseBinding.inflate(inflater, container, false)
        initializeVariables()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exerciseRecyclerView.adapter = exerciseListAdapter

        setUpToolBar()
        subscribeObservable()
    }

    private fun initializeVariables() {
        exerciseListAdapter = ExerciseListAdapter()
        exerciseRecyclerView = binding.fragmentExerciseRecyclerView
        toolbar = binding.fragmentExerciseToolBar
        sessionName = exerciseArgs.exerciseName
    }


    private fun setUpToolBar() {
        toolbar.apply {
            title = sessionName
            setNavigationIcon(R.drawable.ic_arrow_back_24px)
        }

        toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
    }


    private fun subscribeObservable() {
        sessionsViewModel.exerciseState.observe(viewLifecycleOwner, { stateList ->

            stateList.filter { exerciseState -> exerciseState.exerciseName == sessionName }
                .map { it.exerciseList }
                .let { list -> exerciseListAdapter.submitList(list.flatten()) }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}