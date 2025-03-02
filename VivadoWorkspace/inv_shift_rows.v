module inv_shift_rows (
    input [127:0] state,
    output [127:0] new_state
);
    assign new_state[127:120] = state[127:120];  // Row 0 (unchanged)
    assign new_state[119:112] = state[87:80];    // Row 1 (shift right by 1)
    assign new_state[111:104] = state[47:40];    // Row 2 (shift right by 2)
    assign new_state[103:96]  = state[7:0];      // Row 3 (shift right by 3)
    assign new_state[95:88]   = state[95:88];
    assign new_state[87:80]   = state[55:48];
    assign new_state[79:72]   = state[15:8];
    assign new_state[71:64]   = state[103:96];
    assign new_state[63:56]   = state[63:56];
    assign new_state[55:48]   = state[23:16];
    assign new_state[47:40]   = state[111:104];
    assign new_state[39:32]   = state[71:64];
    assign new_state[31:24]   = state[31:24];
    assign new_state[23:16]   = state[119:112];
    assign new_state[15:8]    = state[79:72];
    assign new_state[7:0]     = state[39:32];
endmodule
