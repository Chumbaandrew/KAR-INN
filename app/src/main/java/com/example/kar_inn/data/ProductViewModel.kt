package com.example.kar_inn.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.kar_inn.model.product
import com.example.kar_inn.model.user
import com.example.kar_inn.navigation.ROUTE_HOME
import com.example.kar_inn.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductViewModel (var controller: NavHostController, var context: Context) {


    var mAuth: FirebaseAuth
    val progress: ProgressDialog


    init {
        mAuth=FirebaseAuth.getInstance()
        progress=ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait.....")

    }


    fun saveProduct(
        name: String,
        idNumber: String,
        type: String,
        quantity: String,
        date: String,

        //text: Any?
    ) {
        var id = System.currentTimeMillis().toString()
        var productData = product(name, idNumber, type, quantity,date,id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewProducts(
        product: MutableState<product>,
        products: SnapshotStateList<product>
    ): SnapshotStateList<product> {
        var ref = FirebaseDatabase.getInstance().getReference().child("products")

//        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                products.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(product::class.java)
//                    product.value = value!!
//                    products.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }
}
