package dev.yovany.jcudemy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, greenBox, blueBox, yellowBox, magentaBox) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(redBox) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(greenBox) {
                bottom.linkTo(redBox.top)
                start.linkTo(redBox.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(blueBox) {
                bottom.linkTo(redBox.top)
                end.linkTo(redBox.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                top.linkTo(redBox.bottom)
                start.linkTo(redBox.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(magentaBox) {
                top.linkTo(redBox.bottom)
                end.linkTo(redBox.start)
            })
    }
}

@Composable
fun ConstraintGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val redBox = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.1f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(redBox) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })

    }
}

@Composable
fun ConstraintBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, greenBox, yellowBox) = createRefs()
        val barrier = createEndBarrier(redBox, greenBox)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(redBox) {
                start.linkTo(parent.start, margin = 16.dp)
            })

        Box(modifier = Modifier
            .size(235.dp)
            .background(Color.Green)
            .constrainAs(greenBox) {
                top.linkTo(redBox.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                start.linkTo(barrier)
            })
    }
}

@Composable
fun ConstraintChain() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, greenBox, yellowBox) = createRefs()
        createHorizontalChain(redBox, greenBox, yellowBox, chainStyle = ChainStyle.SpreadInside)

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Red)
            .constrainAs(redBox) {
                start.linkTo(parent.start)
                end.linkTo(greenBox.start)
            })

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Green)
            .constrainAs(greenBox) {
                start.linkTo(redBox.end)
                end.linkTo(yellowBox.start)
            })

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                start.linkTo(greenBox.end)
                end.linkTo(parent.end)
            })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConstraintExamplePreview() {
    ConstraintChain()
}