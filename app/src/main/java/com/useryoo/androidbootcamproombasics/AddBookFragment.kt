package com.useryoo.androidbootcamproombasics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.useryoo.androidbootcamproombasics.databinding.FragmentAddBookBinding
import com.useryoo.androidbootcamproombasics.room.BookModel
import com.useryoo.androidbootcamproombasics.room.BookcaseDB

class AddBookFragment : Fragment() {
    private lateinit var binding:FragmentAddBookBinding
    private lateinit var bookcaseDB: BookcaseDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookcaseDB= BookcaseDB.getBookcaseDB(requireContext())!!
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentAddBookBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            addButton.setOnClickListener{
                val inputBook=bookEditText.text.toString()
                val inputAuthor=authorEditText.text.toString()

                bookcaseDB.bookcaseDAO().addBook(
                    BookModel(
                        bookName = inputBook,
                        author = inputAuthor))
                findNavController().navigate(R.id.action_addBookFragment_to_mainPageFragment)

            }
        }
    }


}