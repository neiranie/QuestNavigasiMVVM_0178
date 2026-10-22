package com.example.questnavigasimvvm_0178.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigasimvvm_0178.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian2(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    OnSubmitBtnClick: (String, String, String) -> Unit
) {
    // Variabel lokal untuk menampung inputan form
    var inputNama by remember { mutableStateOf(value = "") }
    var selectedJK by remember { mutableStateOf(value = "") }
    var inputAlamat by remember { mutableStateOf(value = "") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.home),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input nama
            OutlinedTextField(
                value = inputNama,
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = { inputNama = it }
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // Pilihan jenis kelamin
            Row {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedJK == item,
                            onClick = { selectedJK = item }
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = dimensionResource(id = R.dimen.thickness_divider),
                color = Color.Red
            )

            // Input alamat
            OutlinedTextField(
                value = inputAlamat,
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Alamat") },
                onValueChange = { inputAlamat = it }
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Tombol submit: kirim 3 data (nama, jenis kelamin, alamat) ke callback
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 1f)
                    .padding(horizontal = 25.dp),
                onClick = {
                    OnSubmitBtnClick(inputNama, selectedJK, inputAlamat)
                }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}