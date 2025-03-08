module inv_mix_columns (
    input [127:0] state,
    output [127:0] new_state
);
    function [31:0] mix_column;
        input [31:0] column;
        reg [7:0] s0, s1, s2, s3;
        begin
            s0 = column[31:24];
            s1 = column[23:16];
            s2 = column[15:8];
            s3 = column[7:0];

            mix_column = { (mul_by_0e(s0) ^ mul_by_0b(s1) ^ mul_by_0d(s2) ^ mul_by_09(s3)),
                           (mul_by_09(s0) ^ mul_by_0e(s1) ^ mul_by_0b(s2) ^ mul_by_0d(s3)),
                           (mul_by_0d(s0) ^ mul_by_09(s1) ^ mul_by_0e(s2) ^ mul_by_0b(s3)),
                           (mul_by_0b(s0) ^ mul_by_0d(s1) ^ mul_by_09(s2) ^ mul_by_0e(s3)) };
        end
    endfunction
    
    // Multiplication in GF(2^8) for AES inverse MixColumns
function [7:0] mul_by_0e;
    input [7:0] x;
    begin
        mul_by_0e = (x << 1) ^ (x << 2) ^ (x << 3); // x * 0E
    end
endfunction

function [7:0] mul_by_09;
    input [7:0] x;
    begin
        mul_by_09 = x ^ (x << 3); // x * 09
    end
endfunction

function [7:0] mul_by_0d;
    input [7:0] x;
    begin
        mul_by_0d = x ^ (x << 2) ^ (x << 3); // x * 0D
    end
endfunction

function [7:0] mul_by_0b;
    input [7:0] x;
    begin
        mul_by_0b = x ^ (x << 1) ^ (x << 3); // x * 0B
    end
endfunction


    genvar i;
    generate
        for (i = 0; i < 4; i = i + 1) begin
            assign new_state[(i*32)+31 -: 32] = mix_column(state[(i*32)+31 -: 32]);
        end
    endgenerate
endmodule
