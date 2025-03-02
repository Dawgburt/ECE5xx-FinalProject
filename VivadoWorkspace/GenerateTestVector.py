from Crypto.Cipher import AES
key = bytes.fromhex("2b7e151628aed2a6abf7158809cf4f3c")
cipher = AES.new(key, AES.MODE_ECB)
encrypted = cipher.encrypt(bytes.fromhex("6bc1bee22e409f96e93d7e117393172a"))
print(encrypted.hex())  # Compare with Verilog output
