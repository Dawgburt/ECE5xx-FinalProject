module aes_decrypt_core (
    input clk,
    input [127:0] cipher_text,
    input [127:0] key,
    output reg [127:0] plain_text
);

    reg [127:0] state;
    wire [1407:0] round_keys_flat;
    reg [127:0] round_keys [0:10];
    reg [3:0] round;
    reg [127:0] temp_key;
    reg decrypting;
    integer i;

    // Instantiate AES Key Expansion Module
    aes_key_expansion key_sched (
        .clk(clk),
        .key(key),
        .round_keys_flat(round_keys_flat)
    );
    
always @(posedge clk) begin
    if (!decrypting) begin
        $display("Inside aes_decrypt_core: round_keys_flat before extraction: %h", round_keys_flat);
    end
end



always @(posedge clk) begin
    if (!decrypting) begin
        $display("Inside aes_decrypt_core: Round Keys Flat: %h", round_keys_flat);

        // Initialize round keys
        round_keys[10] <= round_keys_flat[1407:1280];
        round_keys[9]  <= round_keys_flat[1279:1152];
        round_keys[8]  <= round_keys_flat[1151:1024];
        round_keys[7]  <= round_keys_flat[1023:896];
        round_keys[6]  <= round_keys_flat[895:768];
        round_keys[5]  <= round_keys_flat[767:640];
        round_keys[4]  <= round_keys_flat[639:512];
        round_keys[3]  <= round_keys_flat[511:384];
        round_keys[2]  <= round_keys_flat[383:256];
        round_keys[1]  <= round_keys_flat[255:128];
        round_keys[0]  <= round_keys_flat[127:0];

        // Initialize decryption process
        state <= cipher_text;
        temp_key <= round_keys[10];
        state <= state ^ temp_key;
        round <= 9;
        decrypting <= 1;
    end else if (round >= 0) begin
        temp_key <= round_keys[round];
        state <= state ^ temp_key;
        round <= round - 1;
    end
    
        $display("Inside aes_decrypt_core: Extracted Round Keys:");
        for (i = 0; i <= 10; i = i + 1) begin
            $display("Round %0d Key: %h", i, round_keys[i]);
            
    // ? Ensure plain_text is assigned at the end of decryption
    if (round == 0) begin
        plain_text <= state;
        decrypting <= 0;
        $display("Decryption Completed: %h", plain_text);
    end
end
end
endmodule