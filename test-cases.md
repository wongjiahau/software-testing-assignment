# Test cases
## Legend
- CPP means Charge Per Piece (RM)  
- HQP means High Quality Paper  
- DE  means Design Effects    
- N/A means Not Applicable  

Case|Quantity|Options|Expected CPP|  
--|--|--|--|
  R1.1|  1|  none|1.00  
  R1.2|  4|  none|1.00  
  R2.1|  5|  none|0.90
  R2.2| 10|  none|0.90  
  R3.1| 11|  none|0.70  
  R3.2| 20|  none|0.70  
  R4.1| 21|  none|0.50
  R4.2| 50|  none|0.50
  R5.1| 51|  none|0.10
  R5.2|100|  none|0.10
  R6.1|  1|   HQP|1.10
  R6.2|  5|   HQP|1.10
  R7.1|  6|   HQP|1.00
  R7.2| 10|   HQP|1.00
  R8.1| 11|   HQP|0.80
  R8.2| 20|   HQP|0.80
  R9.1| 21|   HQP|0.60
  R9.2| 50|   HQP|0.60
 R10.1| 51|   HQP|0.20
 R10.2|100|   HQP|0.20
 R11.1|  1|    DE|1.10
 R11.2|  5|    DE|1.10
 R12.1|  6|    DE|1.00
 R12.2| 10|    DE|1.00
 R13.1| 11|    DE|0.80
 R13.2| 20|    DE|0.80
 R14.1| 21|    DE|0.60
 R14.2| 50|    DE|0.60
 R15.1| 51|    DE|0.20
 R15.2|100|    DE|0.20
 R15.1| 51|   HQP|0.20
 R15.2|100|   HQP|0.20
 R16.1|  1|HQP,DE|1.20
 R16.2|  5|HQP,DE|1.20
 R17.1|  6|HQP,DE|1.10
 R17.2| 10|HQP,DE|1.10
 R18.1| 11|HQP,DE|0.90
 R18.2| 20|HQP,DE|0.90
 R19.1| 21|HQP,DE|0.70
 R19.2| 50|HQP,DE|0.70
 R20.1| 51|HQP,DE|0.30
 R20.2|100|HQP,DE|0.30
 R21.1|  0|   N/A|Invalid
 R21.2|101|   N/A|Invalid