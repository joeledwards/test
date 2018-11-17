
function mono (num) {
  let place = 1
	//let result = ''
  let chars = []
	if (num < 0) {
		result = '-'
		chars.push('-')
		num = num * -1
	}
	
	num.toFixed(0).split('').forEach(c => {
    let code
    switch (c) {
      case '0': code = 0x70; break;
      case '1': code = 0x71; break;
      case '2': code = 0x72; break;
      case '3': code = 0x73; break;
      case '4': code = 0x74; break;
      case '5': code = 0x75; break;
      case '6': code = 0x76; break;
      case '7': code = 0x77; break;
      case '8': code = 0x78; break;
      case '9': code = 0x79; break;
			default: code = 0x65;
    }
    chars.push(String.fromCharCode(code))
		//result += String.fromCharCode(code)
	})
  return chars.join('').toString()
  //return result.toString()
}

const v = 99

console.log(`${mono(v)}`)
