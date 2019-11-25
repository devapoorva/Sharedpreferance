package com.niks.sharedpreferance.utils;

import android.text.TextUtils;
import android.util.Patterns;

public class Auth {

    public static Boolean isValidEmail(CharSequence sequence)
    {
        return !TextUtils.isEmpty(sequence) && Patterns.EMAIL_ADDRESS.matcher(sequence).matches();
    }

    public static boolean isValidPassword(CharSequence charSequence)
    {
        return (charSequence.length()<5);
    }
}
