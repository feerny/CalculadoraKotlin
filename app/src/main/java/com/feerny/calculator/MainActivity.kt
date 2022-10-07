package com.feerny.calculator

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val operaciones = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val botonSuma:Button=findViewById(R.id.btnSumar);
        botonSuma.setOnClickListener { clickSumar() };

        val botonResta:Button=findViewById(R.id.btnRestar);
        botonResta.setOnClickListener { clickRestar() };

        val botonMulti:Button=findViewById(R.id.btnMulti);
        botonMulti.setOnClickListener { clickMultiplicar() };

        val botonDivi:Button=findViewById(R.id.btnDiv);
        botonDivi.setOnClickListener { clickDividir() };

        val botonHistorial:Button=findViewById(R.id.IdHistorial)
        botonHistorial.setOnClickListener { clickHistorial() }

        val botonCerrarSesion:Button=findViewById(R.id.btnCerrarSesion)
        botonCerrarSesion.setOnClickListener { clickCerrar() }
    }

    private fun clickCerrar(){
        var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor=preferences.edit()
        editor.putString("user","No existe la información")
        editor.putString("pass","No existe la información")
        editor.commit()
        val intent = Intent(this,Login::class.java)
        startActivity(intent)
        Toast.makeText(this,"se cerro sesion correctamente",Toast.LENGTH_SHORT).show()
    }

    private fun clickHistorial(){




        val intent = Intent(this,ActivityHistorial::class.java)

        val miBundle:Bundle= Bundle()



        miBundle.putString("Operaciones",operaciones.toString())

        intent.putExtras(miBundle)

        startActivity(intent)
    }


    private fun clickSumar(){
        val camnum1:EditText=findViewById(R.id.idNum1);
        val num1:String=camnum1.text.toString();
        val num1Int: Int=num1.toInt();

        val camnum2:EditText=findViewById(R.id.idNum2);
        val num2:String=camnum2.text.toString();
        val num2Int: Int=num2.toInt();

        val txtResultado:TextView=findViewById(R.id.textView);

        val suma= num1Int+num2Int;


        operaciones.add("$num1Int + $num2Int = $suma")

        txtResultado.text="$num1Int + $num2Int = $suma"

        camnum1.setText("");
        camnum2.setText("");
    }

    private fun clickRestar(){
        val camnum1:EditText=findViewById(R.id.idNum1);
        val num1:String=camnum1.text.toString();
        val num1Int: Int=num1.toInt();

        val camnum2:EditText=findViewById(R.id.idNum2);
        val num2:String=camnum2.text.toString();
        val num2Int: Int=num2.toInt();

        val txtResultado:TextView=findViewById(R.id.textView);

        val resta= num1Int-num2Int;

        operaciones.add("$num1Int - $num2Int = $resta")

        txtResultado.text="$num1Int - $num2Int = $resta"

        camnum1.setText("");
        camnum2.setText("");
    }

    private fun clickMultiplicar(){
        val camnum1:EditText=findViewById(R.id.idNum1);
        val num1:String=camnum1.text.toString();
        val num1Int: Int=num1.toInt();

        val camnum2:EditText=findViewById(R.id.idNum2);
        val num2:String=camnum2.text.toString();
        val num2Int: Int=num2.toInt();

        val txtResultado:TextView=findViewById(R.id.textView);

        val multi= num1Int*num2Int;

        operaciones.add("$num1Int * $num2Int = $multi")

        txtResultado.text="$num1Int * $num2Int = $multi"

        camnum1.setText("");
        camnum2.setText("");
    }

    private fun clickDividir(){
        val camnum1:EditText=findViewById(R.id.idNum1);
        val num1:String=camnum1.text.toString();
        val num1Int: Int=num1.toInt();

        val camnum2:EditText=findViewById(R.id.idNum2);
        val num2:String=camnum2.text.toString();
        val num2Int: Int=num2.toInt();

        val txtResultado:TextView=findViewById(R.id.textView);

        if (num1Int == 0){
            txtResultado.text=" $num1Int / $num2Int = ERROR"
        }else{
            val div= num1Int/num2Int;

            operaciones.add("$num1Int / $num2Int = $div")

            txtResultado.text="$num1Int / $num2Int = $div"
        }

        camnum1.setText("");
        camnum2.setText("");


    }
}