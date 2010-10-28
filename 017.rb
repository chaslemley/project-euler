def number_to_words num
  words = {}

  words[1] = "one"
  words[2] = "two"
  words[3] = "three"
  words[4] = "four"
  words[5] = "five"
  words[6] = "six"
  words[7] = "seven"
  words[8] = "eight"
  words[9] = "nine"
  words[10] = "ten"
  words[11] = "eleven"
  words[12] = "twelve"
  words[13] = "thirteen"
  words[14] = "fourteen"
  words[15] = "fifteen"
  words[16] = "sixteen"
  words[17] = "seventeen"
  words[18] = "eighteen"
  words[19] = "nineteen"
  words[20] = "twenty"
  words[30] = "thirty"
  words[40] = "forty"
  words[50] = "fifty"
  words[60] = "sixty"
  words[70] = "seventy"
  words[80] = "eighty"
  words[90] = "ninety"
      
  if num == 1000
    return "one thousand"
  elsif num >= 100
    if(num % 100 > 0)
      return number_to_words(num / 100) + " hundred and " + number_to_words(num % 100)
    else
      return number_to_words(num / 100) + " hundred"
    end
  else
    return words[num] if words[num]
    
    
    return number_to_words((num / 10)*10) + " "+ number_to_words(num % 10)
  end
  
  return "BLAH"
end

@sum = 0
(0..1000).inject do |sum, num|
  @sum += (number_to_words num).gsub(" ", "").size
end

puts @sum
