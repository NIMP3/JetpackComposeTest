package dev.yovany.jcudemy.ui.instagram

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import dev.yovany.jcudemy.R

@Composable
fun LoginScreen(onBackClick: () -> Unit = {}) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Header(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ){ onBackClick() }
        Body(
            Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        )
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnabled by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        ImageLogo()
        Spacer(modifier = Modifier.padding(16.dp))
        Email(email) {
            email = it
            isLoginEnabled = enableLogin(email, password)
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Password(password) {
            password = it
            isLoginEnabled = enableLogin(email, password)
        }
        Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(modifier = Modifier.align(Alignment.End)) {}
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(isLoginEnabled) {}
        Spacer(modifier = Modifier.padding(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.padding(24.dp))
        SocialLogin() {}
    }
}

@Composable
fun Footer(modifier: Modifier, onSignUpClick: () -> Unit = {}) {
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                "Don't have an account?",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                "Sign Up",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4EA8E9),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .clickable { onSignUpClick() }
            )

        }
    }
}

@Composable
fun SocialLogin(onSocialLoginClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_facebook),
            contentDescription = "Facebook",
            modifier = Modifier.size(18.dp).clickable { onSocialLoginClick() }
        )
        Text(
            "Login with Facebook",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = Modifier.padding(horizontal = 4.dp).clickable { onSocialLoginClick() }
        )
    }
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(thickness = 1.dp, color = DividerDefaults.color, modifier = Modifier.weight(1f))
        Text(
            "OR",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = DividerDefaults.color, modifier = Modifier.weight(1f))
    }
}

@Composable
fun LoginButton(isLoginEnabled: Boolean, onLoginClick: () -> Unit) {
    Button(
        onClick = onLoginClick,
        enabled = isLoginEnabled,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text("Login", modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun ForgotPassword(modifier: Modifier, onForgotPasswordClick: () -> Unit) {
    Text(
        text = "Forgot Password?",
        fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4EA8E9),
        modifier = modifier.clickable { onForgotPasswordClick() })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onPasswordChange: (String) -> Unit) {
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { Text("Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val resource =
                if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = resource, contentDescription = "Password visibility")
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground, MaterialTheme.shapes.medium)
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onEmailChange: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = onEmailChange,
        placeholder = { Text("Phone number, username or email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground, MaterialTheme.shapes.medium)
    )
}

@Composable
fun ImageLogo() {
    Image(
        painter = painterResource(id = R.drawable.img_logo),
        contentDescription = "Logo",
        Modifier.fillMaxWidth().background(Color.Transparent),
        contentScale = ContentScale.Inside
    )
}

@Composable
fun Header(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close App",
        modifier = modifier.clickable { onBackClick() })
}

fun enableLogin(email: String, password: String) =
    Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4_XL)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}