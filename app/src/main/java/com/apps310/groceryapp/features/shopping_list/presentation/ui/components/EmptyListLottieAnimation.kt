package com.apps310.groceryapp.features.shopping_list.presentation.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.apps310.groceryapp.R

@Composable
fun EmptyListLottieAnimation(){
    val preLoaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.empty_cart_1
        )
    )

    val preLoaderProgress by animateLottieCompositionAsState(
        preLoaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )


    LottieAnimation(
        composition = preLoaderLottieComposition,
        progress = { preLoaderProgress },
        modifier = Modifier.width(200.dp).height(200.dp)
    )
}