package com.example.linh.test1;

import android.text.Editable;
import android.util.Patterns;

/**
 * Created by linh on 4/22/2016.
 */
public class validate {

   public boolean validateEmail (String email)
   {
      if(email.isEmpty())
      {
         return false;
      }
      else
      {
         return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
      }

   }
    public boolean validatePassword (String pass)
    {
        if(pass.isEmpty() || pass.length() < 7 )
        {
            return false;
        }
        else {
            return true;
        }
    }
}
