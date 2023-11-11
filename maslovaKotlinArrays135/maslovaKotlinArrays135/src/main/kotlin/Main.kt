
fun main(args: Array<String>)
{
    while(true)
    {
        println("Домашняя работа Масловой Т. по теме Массивы. Введите номер задания или любую клавишу для выхода")
        val act = readln()
        if (act == "1") main1()
        else if (act == "2") main2()
        else if (act=="3") main3()
        else
        {
            println("Выход")
            break
        }
    }

}


fun charArrayToString(a: CharArray): String
{
    var sb = StringBuilder()
    for (ch in a)
        sb.append(ch)

    return sb.toString()

}
fun main1()
{
    println("Введите ширину и высоту массива для его ручного ввода")
    val col = readln().toInt()
    val row = readln().toInt()
    println("Вводите массив")
    val arr = Array(row) {IntArray(col)}
    for (i in 0..row-1)
    {
        for (j in 0..col-1)
        {
            arr[i][j] = readln().toInt()
        }
    }

    var digits = arrayOf(0,0,0,0,0,0,0,0,0,0)

    for (i in 0..row-1)
    {
        for (j in 0..col-1)
        {
            when(arr[i][j]/100)
            {
                0 -> digits[0]=1
                1 -> digits[1]=1
                2 -> digits[2]=1
                3 -> digits[3]=1
                4 -> digits[4]=1
                5 -> digits[5]=1
                6 -> digits[6]=1
                7 -> digits[7]=1
                8 -> digits[8]=1
                9 -> digits[9]=1
            }
            when(arr[i][j]%10)
            {
                0 -> digits[0]=1
                1 -> digits[1]=1
                2 -> digits[2]=1
                3 -> digits[3]=1
                4 -> digits[4]=1
                5 -> digits[5]=1
                6 -> digits[6]=1
                7 -> digits[7]=1
                8 -> digits[8]=1
                9 -> digits[9]=1
            }
            when(arr[i][j]/10%10)
            {
                0 -> digits[0]=1
                1 -> digits[1]=1
                2 -> digits[2]=1
                3 -> digits[3]=1
                4 -> digits[4]=1
                5 -> digits[5]=1
                6 -> digits[6]=1
                7 -> digits[7]=1
                8 -> digits[8]=1
                9 -> digits[9]=1
            }
        }
    }

    var sum = 0
    for (i in digits)
        sum+=i

    println("Уникальных цифр = ${sum}")

    println("Ваш массив")
    for (i in arr)
        println(i.contentToString())
    println()
    return;
}

fun main2()
{
    val alphLtr_ = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    val alphLtr = alphLtr_.toCharArray()
    val alphCode = arrayOf(
        21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15,
        11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17
    )
    fun LtrToCode(ltr: Char):Int
    {
        var code = alphLtr.indexOf(ltr)
        if (code == -1) return 0;
        return alphCode[code];
    }
    fun CodeToLtr(code: Int):Char
    {
        var ltr = alphCode.indexOf(code)
        if (ltr == -1) return ' ';
        return alphLtr[ltr];
    }
    println("Введите ключевое слово")
    var key = readln();
    key = key.uppercase()
    println("Введите текст")
    var word = readln();
    word = word.uppercase()
    val n = word.length
    val wordOut = word.toCharArray()

    println("Введите 1, чтобы зашифровать текст, любую клавишу, чтобы дешифровать")
    val act = readln();
    var ltrOut: Char
    var shift = 0
    var keyI = 0
    for (i in 0..word.length-1)
    {
        if (keyI>=key.length) keyI=0

        if(act=="1")
        {
            shift = LtrToCode(word[i]) + LtrToCode(key[keyI])
            while (shift>33) shift-=33
        }
        else
        {
            shift = LtrToCode(word[i]) - LtrToCode(key[keyI])
            while (shift < 1) shift += 33
        }

        wordOut[i] = CodeToLtr(shift)
        keyI++
        print(wordOut[i])
    }
    println()
    return;
}

fun main3 ()
{
    println("Введите количество слов (от 4 до 10)")
    val Sn = readln()
    var n = Sn.toInt()
    println("Вводите слова")
    var arr = Array(n,{i -> i.toString()});
    var arrSort = Array(n,{i -> i.toString()});
    for (i in 0..n-1)
    {
        arr[i] = readln()
        arrSort[i]=arr[i]
    }

    var arrSort1 = Array(n,{i -> i.toString()});
    n-=1
    for (i in 0..n)
    {
        var temp = arrSort[i].toCharArray()

        temp.sort()
        arrSort[i] = charArrayToString(temp)
        arrSort1[i] = arrSort[i]
        arrSort[i]+=i.toString()
    }
    arrSort.sort()
    arrSort1.sort()
    for (i in 0..n)
    {
        var temp1 = arrSort[i].toCharArray()
        temp1.reverse()
        arrSort[i] = charArrayToString(temp1)
    }
    var CHindex: Char
    var index = 0
    println("Сгруппированные строки")
    for (i in 0..n)
    {
        CHindex = arrSort[i][0]
        index = CHindex.toString().toInt()
        print(arr[index]); print(", ")
        if (i+1 < n)
            if (arrSort1[i] != arrSort1[i + 1]) println()
    }
    println()
    println()
    return;
}