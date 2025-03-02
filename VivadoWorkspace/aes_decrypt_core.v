module aes_decrypt (
    input clk,
    input [127:0] cipher_text,
    input [127:0] key,
    output reg [127:0] plain_text
);
    reg [127:0] state;
    reg [127:0] round_keys[0:10]; // Stores 11 round keys

    aes_key_expansion key_sched (.key(key), .round_keys(round_keys));

    always @(posedge clk) begin
        state = cipher_text;
        state = state ^ round_keys[10]; // Initial AddRoundKey

        integer i;
        for (i = 9; i >= 0; i = i - 1) begin
            inv_shift_rows shift (.state(state), .new_state(state));
            inv_sub_bytes sub (.state(state), .new_state(state));
            if (i > 0) inv_mix_columns mix (.state(state), .new_state(state));
            state = state ^ round_keys[i];
        end

        plain_text = state; // Output decrypted text
    end
endmodule
