/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    var str = '23';
    var ss = str.replace(/2/g,'abc+|')
        .replace(/3/g,'def+|')
        .replace(/4/g,'ghi+|')
        .replace(/5/g,'jkl+|')
        .replace(/6/g,'mn0+|')
        .replace(/7/g,'pqrs|')
        .replace(/8/g,'tuv+|')
        .replace(/9/g,'wxyz|');
    var arr = digits.split('');
    /*for(let i=0;i<arr.length;i++){
        const char =
    }*/
};