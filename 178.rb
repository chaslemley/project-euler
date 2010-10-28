def is_pandigital? n
  num_arr = n.to_s.split("")
    
  (0..9).each do |index|
    return false if !num_arr.include? index.to_s
  end
  
  true 
end

def is_step_number? n
  num_arr = n.to_s.split("")
  
  (1..(num_arr.length - 1)).each do |index|
    return false if (num_arr[index].to_i - num_arr[index - 1].to_i).abs != 1
  end
  
  true
end

puts "starting"
(9876543210..10000000001).each do |n|
  puts n if is_pandigital?(n) && is_step_number?(n)
end
puts "finished"