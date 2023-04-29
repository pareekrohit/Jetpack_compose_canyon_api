package yodeput.mobile.banking.feature.ui.component


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.infobeans.canyonranchapp.ui.theme.CanyonRanchAppTheme

@Composable
fun DialogMessage(
    title: String,
    message: String,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        title = {  Text(text = title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onBackground) },
        text = { Text(text = message, color = MaterialTheme.colorScheme.onBackground) },
        containerColor = MaterialTheme.colorScheme.background,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "OK", color = Color.Black)
            }
        },
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
        )
    )
}

@Composable
@Preview(name = " Light")
private fun PreviewLight() {
    CanyonRanchAppTheme() {
        DialogMessage("Title","Dialog Message"){}
    }
}
@Composable
@Preview(name = " Dark")
private fun PreviewDark() {
    CanyonRanchAppTheme(darkTheme = true) {
        DialogMessage("Title","Dialog Message"){}
    }
}