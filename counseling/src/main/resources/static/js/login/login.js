const form = document.getElementById('form'),
    studentInput = document.querySelector('.input-field'),
    submitBtn = document.querySelector('#submitBtn'),
    loader = document.querySelector('.loader');

const checkAuthNum =  (res) => () => {
    const isCorrect = studentInput.value === res.code;
    if(isCorrect){

        for(let el in res){
            if(!res.hasOwnProperty(el)){continue;}
            let input = document.createElement('input');
            input.setAttribute("type", "hidden");
            input.setAttribute("name", el);
            input.value = res[el];
            form.appendChild(input);
        }
        let majorFieldId = document.createElement('input');
        majorFieldId.setAttribute("type", "hidden");
        majorFieldId.setAttribute("name", 'majorFieldId');
        majorFieldId.value = (res.studentId).substr(5, 1)
        form.appendChild(majorFieldId);

        form.action = '/';
        form.method = 'POST';
        form.submit();
        return;
    }
    notCorrect("인증번호가 일치하지 않습니다.")
}

const notCorrect = (message) => document.querySelector('.error').innerText = message;

const correct = (res) => {
    notCorrect('');
    studentInput.value = '';
    studentInput.setAttribute("placeholder", "인증번호를 입력하세요.");
    submitBtn.innerText = '로그인';
    submitBtn.removeEventListener('click', sendEmail);
    submitBtn.addEventListener('click', checkAuthNum(res));
}

const fail = async (res) => {
    loader.classList.add('loader-hidden');
    if(res.memberMajor != ''){
        makeInfoModal(infoModal, '#f27474', '<span class="info-modal-icon-left"></span><span class="info-modal-icon-right"></span>', '이번 행사 대상자가 아닙니다.', '계열로 입학한 학생만 가능합니다.');
        await setTimeout( () => infoModal.style.display = 'none',2000);
        return false;
    }
    makeInfoModal(infoModal, '#f27474', '<span class="info-modal-icon-left"></span><span class="info-modal-icon-right"></span>', '메일 확인 중 오류가 발생했습니다.', '잠시 후에 다시 시도해주세요.')
    await setTimeout( () => infoModal.style.display = 'none',2000);
    notCorrect('학번을 다시 확인해주세요.')
}

const changeEmail = (email) => {
    let emailAddress = email.split('@');
    let str = emailAddress[0].substring(emailAddress[0].length / 2);
    emailAddress[0] = emailAddress[0].replace(str, '*'.repeat(str.length));
    return emailAddress.join('@');
}

const success = async (res) => {
    loader.classList.add('loader-hidden');
    makeInfoModal(infoModal, 'blue', '<span class="info-modal-icon-left-v2"></span><span class="info-modal-icon-right-v2"></span>', `${changeEmail(res.memberEmail)}로 <br/>메일을 성공적으로 보냈습니다.`, '')
    await setTimeout(() => infoModal.style.display = 'none'
        , 2000);
    correct(res);
}

const sendEmail = async () => {
    const studentId = studentInput.value.trim(),
        url = '/send-auth-email',
        method = 'POST',
        headers = {"Content-Type" : "application/json"},
        body = JSON.stringify({studentId}),
        fetchInfo = {method, headers, body};

    loader.classList.remove('loader-hidden');

    await fetch(url, fetchInfo)
        .then(response => response.json())
        .then(res => res.state === "FAIL" ?  fail(res) : success(res));

}

submitBtn.addEventListener('click', sendEmail);

