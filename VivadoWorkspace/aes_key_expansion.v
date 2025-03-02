module aes_key_expansion (
    input [127:0] key,
    output reg [127:0] round_keys [0:10]
);
    // Implement AES key schedule (inverse key expansion)
    // This module generates all 11 round keys for decryption
endmodule
