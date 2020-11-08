/**
 * @param {string[]} A
 * @return {string[]}
 */
var commonChars = function(A) {
    let minLength=A[0].length,minLenStr = A[0],iIndex=0;
    A.forEach((v,i) =>{
        if(v.length < minLength){
            minLength = v.length;
            minLenStr = v;
            iIndex = i;
        }
    });
    //var newStrArr = JSON.parse(JSON.stringify(arr));
    A.splice(iIndex,1);
    let minLenStrArr = minLenStr.split('');
    let result = [];
    minLenStrArr.forEach((v,ikey)=>{
        let flag = true;
        let strTemp = JSON.parse(JSON.stringify(A));
        for(let i=0;i<strTemp.length;i++){
            if(strTemp[i].indexOf(v)>=0){
                strTemp[i] = strTemp[i].replace(v,'')
            }else{
                flag = false;
                break;
            }
        }
        if(flag){
            A = JSON.parse(JSON.stringify(strTemp));
            result.push(v);
        }
    });
    return result;


};