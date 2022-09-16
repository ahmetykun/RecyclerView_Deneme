package com.example.recyclerview_deneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview_deneme.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var noteList =
        listOf(
            Note(
                title = "Navigation Editor1",
                text = "After adding a graph, Android Studio opens the graph in the Navigation Editor. In the Navigation Editor,"
            ),
            Note(
                title = "Navigation Editor2",
                text = "After adding a graph, Android Studio opens the graph in the Navigation Editor. In the Navigation Editor,"
            ),
            Note(
                title = "Navigation Editor3",
                text = "After adding a graph, Android Studio opens the graph in the Navigation Editor. In the Navigation Editor,"
            ),
            Note(
                title = "Navigation Editor4",
                text = "After adding a graph, Android Studio opens the graph in the Navigation Editor. In the Navigation Editor,"
            ),
            Note(
                title = "Navigation Editor4",
                text = "After adding a graph, Android Studio opens the graph in the Navigation Editor. In the Navigation Editor,"
            ),

            )

    private var adapter_note = NoteAdapter(onNoteDeleteClick = {
        ondeleteNote(it)

    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewNote.adapter = adapter_note
        adapter_note.submitList(noteList)

        binding.buttonAdd.setOnClickListener {
            addNote()
        }
    }

    private fun ondeleteNote(note: Note) {
        noteList = noteList.toMutableList().apply { remove(note) }
        adapter_note.submitList(noteList)
    }

    private fun addNote() {
        val title = binding.editTextTitle.text?.toString()


        if (title.isNullOrBlank()) {
            Snackbar.make(binding.root, "Lütfen title giriniz", Snackbar.LENGTH_SHORT).show()
            return
        }
        val text = binding.editTexttext.text?.toString()

        if (text.isNullOrBlank()) {
            Snackbar.make(binding.root, "Lütfen text giriniz", Snackbar.LENGTH_SHORT).show()
            return
        }
        val note = Note(text, title)
        noteList = noteList.toMutableList().apply { add(0, note) }
        adapter_note.submitList(noteList){
            binding.recyclerViewNote.scrollToPosition(0)
        }


        binding.editTexttext.text = null
        binding.editTextTitle.text = null


    }


}








