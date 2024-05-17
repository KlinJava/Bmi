package com.hank.bmi

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hank.bmi.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewModel: GuessViewModel //使用 lateinit讓它後面再初始化
    val TAG = MainActivity2::class.java.simpleName //簡單名稱取得
    //lateinit：晚點一定會產生物件，既不用輸入null，又可以晚點再給資料
    private lateinit var binding:ActivityMainBinding //使用 lateinit讓它後面再初始化
    val secret1 = (1..10).random()
    val game = GuessGame()

    //OnCreate：代表MainActivity在Android系統裡面產生之後，自動就會執行的一個方法
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main) //使用 binding功能後，停用
        R.id.hello_main
        R.drawable.pig
        R.string.ok
        R.color.messageColor

        binding = ActivityMainBinding.inflate(layoutInflater) //充氣機
        setContentView(binding.root) //把畫面那一塊交給 setContentView，註解 //setContentView(R.layout.activity_main)
                Toast.makeText(this,"secret:${game.secret}",Toast.LENGTH_LONG).show()

        viewModel = ViewModelProvider(this).get(GuessViewModel::class.java) //得到 ViewModel物件

/*        viewModel.counter3.observe(this, Observer {//傾聽 counter 資料一有變動，就會跑來 Observer{..}中執行
//        viewModel.counter3.observe(this, Observer { test -> //改寫it，傾聽 counter 資料一有變動，就會跑來 Observer{..}中執行
            binding.counter.text = it.toString()
//            binding.counter.text = test.toString()
        })*/

        //Lambda語法如為最後一個參數，可以拿到小括號的外面
        viewModel.counter3.observe(this) {//傾聽 counter 資料一有變動，就會跑來 Observer{..}中執行
            binding.counter.text = it.toString()
        }

        viewModel.status.observe(this, Observer {//傾聽 status 資料一有變動，就會跑來 Observer{..}中執行
            val message = when (it) {
                GameStatus.BIGGER -> getString(R.string.bigger)
                GameStatus.SMALLER -> getString(R.string.smaller)
                GameStatus.INIT -> ""
                else -> getString(R.string.you_got_it)
            }
            if (it != GameStatus.INIT) {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.info)) //設定抬頭 "Info"
                    .setMessage(message) //設定訊息內容
                    //                .setPositiveButton(getString(R.string.ok),null) //要不要有按鈕，2個參數還沒學到 listener，故先給 null
                    .setPositiveButton(
                        getString(R.string.ok),
                        null
                    ) //要不要有按鈕，2個參數還沒學到 listener，故先給 null，okLisener為介面實作
                    .setNegativeButton("Replay") { dialog, which -> //{..}為 lambda語法，取代 okLisener實作，簡單很多；如果是最後一個參數，可以拿到括號外面
                        Log.d(TAG, "Replay")
                        viewModel.reset()
                    }
                    .show() //顯示給使用者看
            }
        })

        viewModel.secretData.observe(this){//傾聽 secretData 資料一有變動，就會跑來 Observer{..}中執行
            Toast.makeText(this,"view secret:${game.secret}",Toast.LENGTH_LONG).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun reset(view:View) {
        game.reset()
        binding.number.text.clear()
        binding.counter.text = "0"
        Toast.makeText(this,"secret:${game.secret}",Toast.LENGTH_LONG).show()
    }
    fun guess(view:View) { //這個方法，會在按鈕 guess_button被按下(on_click)的時候執行
//        viewModel.guess(binding.counter.text.toString().toInt()) //測試 ViewModel監視變動功能
        viewModel.guess(binding.number.text.toString().toInt()) //測試 ViewModel監視變動功能
//            guessDetect2() // 搭配 secret變數
//            guessDetect1() // 搭配 secret2變數
    }

    //傳資料到第 2個 Activity
    fun setNickname(view:View) {
        val intent = Intent(this,NicknameActivity::class.java)
        intent.putExtra("EXTRA_LEVEL",3)
        intent.putExtra("NAME","Hank")
        startActivity(intent)
    }

    //寫法2，使用 Lisener及Lambda語法
    private fun guessDetect2() {
        if (!binding.number.text.toString()
                .equals("")
        ) { //binding 帶出 hello_main元件，在程式中會變為 binding.helloMain
            val num = binding.number.text.toString().toInt()
            val message = when (game.guess(num)) {
                GuessGame.Status.SMALLER -> getString(R.string.smaller)
                GuessGame.Status.BIGGER -> getString(R.string.bigger)
                else -> getString(R.string.you_got_it)
            }
            binding.counter.text = game.counter.toString()

            val okLisener = object : OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Log.d(TAG, "enter a ok")
                }

            }
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.info)) //設定抬頭 "Info"
                .setMessage(message) //設定訊息內容
    //                .setPositiveButton(getString(R.string.ok),null) //要不要有按鈕，2個參數還沒學到 listener，故先給 null
                .setPositiveButton(
                    getString(R.string.ok),
                    okLisener
                ) //要不要有按鈕，2個參數還沒學到 listener，故先給 null，okLisener為介面實作
                .setNegativeButton("Replay", { dialog, which -> //{..}為 lambda語法，取代 okLisener實作，簡單很多
                    Log.d(TAG, "Replay")
                    game.reset()
                    binding.number.text.clear()
                    binding.counter.text = game.counter.toString()
                })
                .show() //顯示給使用者看
        } else {
            Toast.makeText(this, getString(R.string.please_enter_a_number_1_10), Toast.LENGTH_LONG)
                .show()
        }
    }

    //寫法1，一般語法
    private fun guessDetect1() {
        //println("Clicked") //訊息會出現在 Logcat中控台中，很快就會被訊息往前推
        if (!binding.number.text.toString().equals("")) { //「不是」空字串才執行
            val num = binding.number.text.toString().toInt()
            Log.d(
                "MainActivity2",
                num.toString()
            ) //Log類別，可定義4種等級：i(INFO),d(DEGUB),w(WARN),wtf(What a Terrible Failure)
            var message = if (num > secret1) {
    //                "Smaller"
                getString(R.string.smaller) //正常語法為 resources.getString(R.string.smaller)，因為太常用，故直接 getString()就可以用了
            } else if (num < secret1) {
    //                "Bigger"
                getString(R.string.bigger)
            } else {
    //                "You get it!"
                getString(R.string.you_got_it)
            }
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.info)) //設定抬頭 "Info"
                .setMessage(message) //設定訊息內容
                .setPositiveButton(getString(R.string.ok), null) //要不要有按鈕，2個參數還沒學到 listener，故先給 null
                .show() //顯示給使用者看
        } else {
            //比較不重要的訊號：下方出現訊息框，使用 Toast類別
    //            Toast.makeText(this, "please_enter_a_number_1_10",Toast.LENGTH_LONG).show()
            Toast.makeText(this, getString(R.string.please_enter_a_number_1_10), Toast.LENGTH_LONG)
                .show()
        }
    }
}