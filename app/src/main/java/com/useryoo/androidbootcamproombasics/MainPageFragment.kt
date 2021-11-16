package com.useryoo.androidbootcamproombasics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.useryoo.androidbootcamproombasics.databinding.FragmentMainPageBinding
import com.useryoo.androidbootcamproombasics.room.BookModel
import com.useryoo.androidbootcamproombasics.room.BookcaseAdapter
import com.useryoo.androidbootcamproombasics.room.BookcaseDB

class MainPageFragment : Fragment() {
    private lateinit var binding:FragmentMainPageBinding
    private lateinit var bookcaseDB: BookcaseDB
    private lateinit var listBook:List<BookModel?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookcaseDB= BookcaseDB.getBookcaseDB(requireContext())!!
        listBook=bookcaseDB.bookcaseDAO().allBooks()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonAdd.setOnClickListener{
                findNavController().navigate(R.id.action_mainPageFragment_to_addBookFragment)
            }
            updatebutton.setOnClickListener {
                listBook=bookcaseDB.bookcaseDAO().allBooks()
                showAllBooks()
            }
        }
    }
    fun showAllBooks(){
        binding.apply {
            if(listBook.isEmpty()){
                val show = Snackbar.make(requireView(), "There is no book",1000).show()
            }
            else{
                val bookcaseAdapter=BookcaseAdapter(listBook)
                rvBook.adapter=bookcaseAdapter
                rvBook.layoutManager=GridLayoutManager(context,2)
                rvBook.setHasFixedSize(true)
            }
        }
    }

}