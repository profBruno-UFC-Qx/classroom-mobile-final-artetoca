package com.example.artetoca

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.height
import com.example.artetoca.ui.theme.ArtetocaTheme

@Composable
fun sobre( modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.artetoca)
    val Rosa = Color(0xFFFEF5F5)
    val RosaTitulo = Color(0xFFE88BA0)

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = image,
                contentDescription = "Logo da associacao",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Artetoca",
                    fontSize = 24.sp,
                    color = RosaTitulo,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth()

                )
                Text(
                    text = "Arte feita com amor",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth()

                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ){
            Text(
                text = "Nossa história",
                fontSize = 24.sp,
                color = RosaTitulo,
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "A Artetoca foi fundada em 2024 e nasceu do sonho de unir talentos" +
                         "e dar visibilidade aos trabalhos dos artesãos e artistas de Ocara, Ceará." +
                        "Atuamos com diferentes técnicas e linguagens: crochê, barro, bordado, costura criativa, pintura e escultura." +
                        "Além da produção artística, realizamos oficinas, exposições, feiras culturais e projetos comunitários " +
                                "que fortalecem a identidade e a economia criativa do nosso município.",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,

                modifier = Modifier.fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ){
            Text(
                text = "Nossos Valores",
                fontSize = 24.sp,
                color = RosaTitulo,
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Acreditamos na importância da preservação cultural, na promoção da arte " +
                        "como meio de desenvolvimento e na geração de renda sustentável para a " +
                        "comunidade. Cada ação que realizamos é guiada por esses princípios, " +
                        "que refletem nosso compromisso com o bem-estar social e ambiental ",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,

                modifier = Modifier.fillMaxWidth()

            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun sobrePreview() {
    ArtetocaTheme {
        sobre()
    }
}