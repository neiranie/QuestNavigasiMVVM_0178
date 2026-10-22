package com.example.questnavigasimvvm_0178

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasimvvm_0178.view.FormIsian2
import com.example.questnavigasimvvm_0178.view.TampilData2

enum class Navigasi2 {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp2(
    navController: NavHostController = rememberNavController()
) {
    // Variabel lokal untuk menyimpan data sementara
    var namaSiswa by remember { mutableStateOf("") }
    var jkSiswa by remember { mutableStateOf("") }
    var alamatSiswa by remember { mutableStateOf("") }

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi2.FormulirSaya.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi2.FormulirSaya.name) {
                FormIsian2(
                    OnSubmitBtnClick = { nama, jk, alamat ->
                        // Simpan data ke variabel lokal sebelum pindah halaman
                        namaSiswa = nama
                        jkSiswa = jk
                        alamatSiswa = alamat

                        navController.navigate(route = Navigasi2.Detail.name)
                    }
                )
            }

            composable(route = Navigasi2.Detail.name) {
                TampilData2(
                    nama = namaSiswa,
                    jenisKelamin = jkSiswa,
                    alamat = alamatSiswa,
                    onBackBtnClick = { cancelAndBackToFormulirSaya(navController) }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulirSaya(
    navController: NavHostController
) {
    navController.popBackStack(
        route = Navigasi2.FormulirSaya.name,
        inclusive = false
    )
}