module inv_sub_bytes (
    input [127:0] state,
    output [127:0] new_state
);
    reg [7:0] inv_sbox [0:255]; // S-Box lookup table

    initial begin
        // Initialize inverse S-Box values (precomputed for speed)
        $readmemh("inv_sbox.hex", inv_sbox);
    end

    genvar i;
    generate
        for (i = 0; i < 16; i = i + 1) begin
            assign new_state[(i*8)+7 -: 8] = inv_sbox[state[(i*8)+7 -: 8]];
        end
    endgenerate
endmodule
