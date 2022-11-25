$text = Get-EventLog -LogName Security -InstanceID 4656 | Select-Object -Property TimeGenerated, Message | Where Message -like "*HONEYPOT*" | Where Message -notlike "*C:\Windows\explorer.exe*" | Where Message -notlike "*C:\Windows\System32\notepad.exe*"| Where Message -notlike "*C:\Windows\System32\smartscreen.exe*" | ft -HideTableHeaders -Wrap | out-string
$separator = "`r`n"
$text = $text.Split($separator)
$lineLength = 72

For ($i = 0; $i -lt [math]::floor($text.Length/$lineLength); $i++) {
    $timeParts = $text[2 + 72*$i].Trim() -split " ", 4
    $dateTime = $timeParts[0] + " " + $timeParts[1] + " " + $timeParts[2]

    $file = $text[24 + 72*$i].Trim() -split ':', 2
    $file = $file[1].Trim()

    $process = $text[36 + 72*$i].Trim() -split ':', 2
    $process = $process[1].Trim()

    echo $dateTime, $file, $process
    echo "-----"
}