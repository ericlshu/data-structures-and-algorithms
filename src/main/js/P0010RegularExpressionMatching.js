/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */


var s = 'aaaaab';
var p = 'b'


var isMatch = function(s, p) {
    var regex = p.split('*');

    for(var i = 0;i< regex.length;i++){
        if(regex[i]==='.'){
            if(i === regex.length-1){
                return true;
            }else{
                const nextR = regex[i+1];
                const p = s.indexOf(nextR);
                if(p<0){
                    return false;
                }else{

                }

            }
        }else{
            const reg = new RegExp((regex[i]+'*'))
            s.replace(reg,'');
        }
    }

};