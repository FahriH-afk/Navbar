package com.example.navbar.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.navbar.R
import com.example.navbar.data.OrderUIState
import com.example.navbar.ui.komponen.FormatLabelHarga


@Composable
fun HalamanDua (
    orderUIState: OrderUIState,
    onCancelButtonClicked: () -> Unit,
    //onSendBUttonClicked: (String, string) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(R.string.quantity), orderUIState.jumlah),
        Pair(stringResource(R.string.flavor), orderUIState.rasa)
    )
    Column (
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
       Column (
           modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
           verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
       ) {
          items.forEach { items ->
              Column {
                  Text(items.first.uppercase())
                  Text(text = items.second.toString(), fontWeight = FontWeight.Bold)
              }
              Divider(
                  thickness = dimensionResource(R.dimen.thickness_divider))
          }
          Spacer(
              modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
           FormatLabelHarga(
               subtotal = orderUIState.harga,
               modifier = Modifier.align(Alignment.End)
               )
       }
       Row (
           modifier = Modifier
               .weight(1f, false)
               .padding(dimensionResource(R.dimen.padding_medium))
       ) {
           Column (
               verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
           ) {
               Button(
                   modifier = Modifier.fillMaxWidth(),
                   onClick = {}
               ) {
                  Text(stringResource(R.string.send))
               }
               OutlinedButton(
                   modifier = Modifier,
                   onClick = onCancelButtonClicked
               ) {
                   Text(stringResource(R.string.cancel))
               }
           }
       }
    }
}