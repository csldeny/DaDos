package net.sldeny.dados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.sldeny.dados.ui.theme.DaDosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaDosTheme {
                    DaDosApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DaDosApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentHeight(Alignment.Top)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var resultDiceOne by remember {
        mutableStateOf(1)
    }
    var resultDiceTwo by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = getAlgo(resultDiceOne)),
            contentDescription = resultDiceOne.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = getAlgo(resultDiceTwo)),
            contentDescription = resultDiceTwo.toString()
        )

        Button(onClick = {
            resultDiceOne= (1..6).random()
            resultDiceTwo= (1..6).random()
        }) {
            Text(stringResource(R.string.roll))
        }

    }


}

private fun getAlgo(valor : Int):Int{
    val imageResource=when(valor){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else ->R.drawable.dice_6
    }

    return imageResource
}
