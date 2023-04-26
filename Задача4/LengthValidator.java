import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class LengthValidator implements TextWatcher {
    private final int minLength;
    private final int maxLength;
    private final EditText editText;

    public LengthValidator(int minLength, int maxLength, EditText editText) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        String text = s.toString();
        if (text.length() < minLength || text.length() > maxLength) {
            String errorMessage = String.format("Text length should be between %d and %d characters", minLength, maxLength);
            editText.setError(errorMessage);
        } else {
            editText.setError(null);
        }
    }
}