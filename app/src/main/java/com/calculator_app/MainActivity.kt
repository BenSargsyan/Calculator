package com.calculator_app


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.Button
import android.widget.EditText
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
   private lateinit var calc:EditText
   private lateinit var result:EditText

    private  var dotInserted:Boolean = false
    private  var operatorInserted:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    result=findViewById(R.id.result)
    calc=findViewById(R.id.display)



    val x:Button=findViewById(R.id.backspace)
    val c:Button=findViewById(R.id.clear)

    val btn0: Button =findViewById(R.id.button0)
    val btn1: Button =findViewById(R.id.button1)
    val btn2: Button =findViewById(R.id.button2)
    val btn3: Button =findViewById(R.id.button3)
    val btn4: Button =findViewById(R.id.button4)
    val btn5: Button =findViewById(R.id.button5)
    val btn6: Button =findViewById(R.id.button6)
    val btn7: Button =findViewById(R.id.button7)
    val btn8: Button =findViewById(R.id.button8)
    val btn9: Button =findViewById(R.id.button9)

    val btnDot:Button=findViewById(R.id.buttonDot)
    val btnSum: Button =findViewById(R.id.buttonsum)
    val btnSub: Button =findViewById(R.id.buttonsub)
    val btnMul: Button =findViewById(R.id.buttonmul)
    val btnDiv: Button =findViewById(R.id.buttondiv)
    val btnEqu:Button=findViewById(R.id.buttonequ)

        calc.showSoftInputOnFocus=false
        result.showSoftInputOnFocus=false
        calc.setSelection(0)
        result.setSelection(0)

        btn0.setOnClickListener {
            if(calc.text.isNotEmpty()) {
                "0".updateText()
            }
        }

        btn1.setOnClickListener {
            "1".updateText()
        }

        btn2.setOnClickListener {
            "2".updateText()
        }

        btn3.setOnClickListener {
            "3".updateText()
        }

        btn4.setOnClickListener {
            "4".updateText()
        }

        btn5.setOnClickListener {
            "5".updateText()
        }

        btn6.setOnClickListener {
            "6".updateText()
        }

        btn7.setOnClickListener {
            "7".updateText()
        }

        btn8.setOnClickListener {
            "8".updateText()
        }

        btn9.setOnClickListener {
            "9".updateText()
        }

        x.setOnClickListener {
            backspace(calc.selectionStart)
        }

        c.setOnClickListener {
           calc.setText("")
            dotInserted=false
            operatorInserted=false
        }

        btnDot.setOnClickListener {
            if(calc.text.isEmpty())
            {
                calc.setText("0.")
                calc.setSelection(2)
                dotInserted=true
            }
            else {
                if (dotInserted == false) {
                   /* ".".updateText()
                    dotInserted = true*/
                if (calc.text.isNotEmpty() && calc.selectionStart != 0) {
                    val cursorPos: Int = calc.selectionStart
                    val left: Char = calc.text[cursorPos - 1]

                    if (cursorPos != calc.text.length) {
                        val right: Char = calc.text[cursorPos]
                        if ((right < '0' || right > '9')) {
                            backspace(cursorPos + 1)
                            ".".updateText()
                            dotInserted = true
                            calc.setSelection(cursorPos)
                        } else {
                            if ((left < '0' || left > '9')) {
                                backspace(cursorPos)
                                ".".updateText()
                                dotInserted = true
                            } else {
                                ".".updateText()
                                dotInserted = true
                            }
                        }
                    } else {
                        if (left < '0' || left > '9') {
                            backspace(cursorPos)
                            ".".updateText()
                            dotInserted = true
                        } else {
                            ".".updateText()
                            dotInserted = true
                        }
                    }
                }
                }
            }
        }

        btnDiv.setOnClickListener {
            dotInserted=false
            if(calc.text.isNotEmpty() && calc.selectionStart!=0) {
                val cursorPos:Int=calc.selectionStart
                val left:Char=calc.text[cursorPos-1]

                if(cursorPos!=calc.text.length ) {
                    val right:Char= calc.text[cursorPos]
                    if ((right < '0' || right > '9')) {
                        backspace(cursorPos+1)
                        "/".updateText()
                        dotInserted = false
                        calc.setSelection(cursorPos)
                    }
                    else {
                        if ((left < '0' || left > '9')) {
                            backspace(cursorPos)
                            dotInserted = false
                            "/".updateText()
                        } else {
                            dotInserted = false
                            "/".updateText()
                        }
                    }
                }
                else{
                    if(left<'0'||left>'9')
                    {
                        backspace(cursorPos)
                        dotInserted = false
                        "/".updateText()
                    }

                    else{
                        "/".updateText()
                        dotInserted = false
                    }
                }
            }
        }

        btnMul.setOnClickListener {
            dotInserted=false
            if(calc.text.isNotEmpty() &&  calc.selectionStart!=0) {
                val cursorPos:Int=calc.selectionStart
                val left:Char=calc.text[cursorPos-1]

                if(cursorPos!=calc.text.length ) {
                    val right:Char= calc.text[cursorPos]
                    if ((right < '0' || right > '9')) {
                        backspace(cursorPos+1)
                        dotInserted = false
                        "*".updateText()
                        calc.setSelection(cursorPos)
                    }
                    else {
                        if ((left < '0' || left > '9')) {
                            backspace(cursorPos)
                            dotInserted = false
                            "*".updateText()
                        } else {
                            dotInserted = false
                            "*".updateText()
                        }
                    }
                }
                else{
                    if(left<'0'||left>'9')
                    {
                        backspace(cursorPos)
                        dotInserted = false
                        "*".updateText()
                    }

                    else{
                        dotInserted = false
                        "*".updateText()
                    }
                }
            }
        }

        btnSum.setOnClickListener {
            dotInserted=false
            if(calc.text.isNotEmpty() && calc.selectionStart!=0) {
                val cursorPos:Int=calc.selectionStart
                val left:Char=calc.text[cursorPos-1]

                if(cursorPos!=calc.text.length ) {
                    val right:Char= calc.text[cursorPos]
                    if ((right < '0' || right > '9')) {
                        backspace(cursorPos+1)
                        "+".updateText()
                        calc.setSelection(cursorPos)
                    }
                    else {
                        if ((left < '0' || left > '9')) {
                            backspace(cursorPos)
                            "+".updateText()
                        } else {
                            "+".updateText()
                        }
                    }
                }
                else{
                    if(left<'0'||left>'9')
                    {
                        backspace(cursorPos)
                        "+".updateText()
                    }

                    else{
                        "+".updateText()
                    }
                }
            }
        }

        btnSub.setOnClickListener {
            dotInserted=false
            if(calc.text.isNotEmpty() && calc.selectionStart!=0) {
                val cursorPos:Int=calc.selectionStart
                val left:Char=calc.text[cursorPos-1]

                if(cursorPos!=calc.text.length ) {
                    val right:Char= calc.text[cursorPos]
                    if ((right < '0' || right > '9')) {
                        backspace(cursorPos+1)
                        "-".updateText()
                        calc.setSelection(cursorPos)
                    }
                    else {
                        if ((left < '0' || left > '9')) {
                            backspace(cursorPos)
                            "-".updateText()
                        } else {
                            "-".updateText()
                        }
                    }
                }
                else{
                    if(left<'0'||left>'9')
                    {
                        backspace(cursorPos)
                        "-".updateText()
                    }

                    else{
                        "-".updateText()
                    }
                }
            }
        }

        btnEqu.setOnClickListener {
            val userExp:String=calc.text.toString()
            val exp= Expression(userExp)
            val res:String=exp.calculate().toString()
            result.setText(res)
        }

    }

    private fun String.updateText()
    {
        val old:String=calc.text.toString()
        val cursorPos:Int=calc.selectionStart
        val left:String=old.substring(0,cursorPos)
        val right:String=old.substring(cursorPos)
        calc.setText(String.format("%s%s%s",left,this,right))
        calc.setSelection(cursorPos+1)
    }

    private fun backspace(cursor:Int)
    {

        val cursorPos=cursor
        val textLength=calc.text.length

        if(cursorPos!=0&&textLength!=0)
        {
            if(calc.text[calc.text.toMutableList().lastIndex] <'0' ||
                calc.text[calc.text.toMutableList().lastIndex] >'9' )
            {
                dotInserted=true
            }
            val sb=SpannableStringBuilder(calc.text)
            sb.replace(cursorPos-1,cursorPos,"")
            calc.setText(sb)
            calc.setSelection(cursorPos-1)
        }
    }
}

