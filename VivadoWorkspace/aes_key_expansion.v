module aes_key_expansion (
    input clk, // ? Added clock input
    input [127:0] key,
    output reg [1407:0] round_keys_flat
);
    reg [127:0] round_keys [0:10];

    always @(posedge clk) begin
        $display("Inside aes_key_expansion: Key Received: %h", key);

        if (key !== 128'bx) begin
            round_keys[0] = key; // First round key is the given key
            round_keys[1] = key ^ 128'h1;
            round_keys[2] = key ^ 128'h2;
            round_keys[3] = key ^ 128'h3;
            round_keys[4] = key ^ 128'h4;
            round_keys[5] = key ^ 128'h5;
            round_keys[6] = key ^ 128'h6;
            round_keys[7] = key ^ 128'h7;
            round_keys[8] = key ^ 128'h8;
            round_keys[9] = key ^ 128'h9;
            round_keys[10] = key ^ 128'hA;

            round_keys_flat <= {
                round_keys[10], round_keys[9], round_keys[8], round_keys[7],
                round_keys[6], round_keys[5], round_keys[4], round_keys[3],
                round_keys[2], round_keys[1], round_keys[0]
            };
 $display("Inside aes_key_expansion: round_keys_flat after assignment: %h", round_keys_flat);
 
            $display("Inside aes_key_expansion: Generated Round Keys:");
            for (integer i = 0; i <= 10; i = i + 1) begin
                $display("Round %0d Key: %h", i, round_keys[i]);
            end
        end else begin
            $display("Inside aes_key_expansion: Key is still X!");
            round_keys_flat <= 1408'b0;  // Prevent undefined X values
        end
    end
endmodule
