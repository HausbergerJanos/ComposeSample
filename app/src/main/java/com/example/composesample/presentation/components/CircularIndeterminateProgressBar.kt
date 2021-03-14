package com.example.composesample.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed: Boolean
) {
    if (isDisplayed) {
        WithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            val constraints = myConstraints(0.3f)

            ConstraintLayout(
                modifier = Modifier.fillMaxSize(),
                constraintSet = constraints
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.layoutId("progressBar"),
                    color = MaterialTheme.colors.primary
                )
            }
        }
    }
}

private fun myConstraints(verticalBias: Float): ConstraintSet {
    return ConstraintSet {
        val guideline = createGuidelineFromTop(verticalBias)
        val progressBar = createRefFor("progressBar")

        constrain(progressBar) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}