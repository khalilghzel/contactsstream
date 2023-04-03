package com.ghzel.contactstream.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ghzel.contactstream.R


@Composable
fun CircularIndeterminateProgressBar(isDisplayed: Boolean, modifier: Modifier) {
    if (isDisplayed) {
        val interactionSource = remember { MutableInteractionSource() }
// just a test for triggering the last colmmited files again

        Box(modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {}
            .fillMaxSize()
            .background(Loading_Bg)) {

            Row(
                modifier = modifier

                    .clip(RoundedCornerShape(10.dp))
                    .background(GreySC2),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularProgressIndicator(
                        color = TextColor,
                        strokeWidth = 3.dp,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = stringResource(R.string.treatment),
                        modifier = Modifier,
                        color = TextColor,
                        fontFamily = ubuntu,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }
    }
}



















