package com.example.homework1_7m.ui.update_profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.core.core.BaseFragment
import com.example.homework1_7m.databinding.FragmentUpdateProfileBinding
import java.io.FileNotFoundException
import java.io.InputStream


class UpdateProfileFragment : BaseFragment<FragmentUpdateProfileBinding>(FragmentUpdateProfileBinding::inflate) {
    var activityResultLauncher: ActivityResultLauncher<Intent>? = null
    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        // Handle the returned Uri
    }
    override fun setupUI() {
        initImageListener()
        getImages()
        binding().imgBack.setOnClickListener{
            findNavController().navigateUp()
        }
        binding().bgProfileImageView.setOnClickListener{
            getContent.launch("image/*")
        }
    }
    fun getImages() {
        activityResultLauncher = registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                try {
                    assert(result.data != null)
                    val imageUri = result.data!!.data
                    val imageStream: InputStream? =
                        requireActivity().contentResolver.openInputStream(
                            imageUri!!
                        )
                    val selectedImage: Bitmap = BitmapFactory.decodeStream(imageStream)
                    binding().bgProfileImageView.setImageBitmap(selectedImage)
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
            }
        }
    }
    private fun initImageListener() {
        val uri = Uri.parse(getImages().toString())
            Glide.with(binding().bgProfileImageView).load(uri).
            into(binding().bgProfileImageView)
    }
}