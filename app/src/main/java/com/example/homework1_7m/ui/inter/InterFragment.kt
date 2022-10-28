package com.example.homework1_7m.ui.inter

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core.Resource
import com.example.core.core.BaseFragment
import com.example.domain.users.model.Login
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.FragmentInterBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InterFragment : BaseFragment<FragmentInterBinding>(FragmentInterBinding::inflate) {
    private lateinit var auth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient
    private val viewModel: InterViewModel by viewModels()

    override fun setupUI() {
      onClick()
        auth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        binding().imgGoogle.setOnClickListener{
            signIn()
            findNavController().navigate(R.id.mainFragment)
        }
    }
    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }
    }
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    private fun updateUI(user: FirebaseUser?) {
    }
    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
    fun onClick(){
        binding().txtRegister.setOnClickListener{
            findNavController().navigate(R.id.secondFragment)
        }

        binding().txtReestablish.setOnClickListener {
            findNavController().navigate(R.id.restorePasswordFragment)
        }

        binding().materialButton.setOnClickListener {

            val phoneNumber = binding().phoneNumber.text.toString().trim()
            val pass = binding().pass.text.toString().trim()

            val login = Login(phoneNumber, pass, "1")

            viewModel.getLogin(login)


            lifecycleScope.launch {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.login.collect {
                        when (it) {
                            is Resource.Success -> {
                                findNavController().navigate(R.id.mainFragment)
                            }
                            is Resource.Error -> {
                                Toast.makeText(requireContext(), "Unknown error!!!",
                                    Toast.LENGTH_SHORT).show()
                            }
                            is Resource.Loading -> {
                            }
                        }
                    }
                }
            }
        }
    }
}