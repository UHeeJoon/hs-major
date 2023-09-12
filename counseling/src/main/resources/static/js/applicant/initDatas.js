const applicantSubmitBtn = document.querySelector('#applicant>.submit_button');
const cancelSubmitBtn = document.querySelector('#cancel>.submit_button');
const modal = document.querySelector(".modal");

const checkTime = (data) => {
    // 3개 가능할 때
    return (data.timeId === myApplicantList[0]?.timeId && data.applicantDate === myApplicantList[0]?.applicantDate) || (data.timeId === myApplicantList[1]?.timeId && data.applicantDate === myApplicantList[0]?.applicantDate);
}

const openApplicant = (data) => () => {
    // 3개 가능할 때
    if(myApplicantList.length === 2){
        close();
        makeInfoModal(infoModal, '#f27474', '<span class="info-modal-icon-left"></span><span class="info-modal-icon-right"></span>', '상담 신청은 2개까지만 가능합니다.', '다른 상담 취소 후 신청 가능 합니다.')
        setTimeout( () => infoModal.style.display = 'none'
            ,1500);
        return;
    }

    if(checkTime(data)){
        close();
        makeInfoModal(infoModal, '#f27474', '<span class="info-modal-icon-left"></span><span class="info-modal-icon-right"></span>', '동일 시간 대에 신청한 상담이 있습니다.', '다른 상담 취소 후 신청 가능 합니다.')
        setTimeout( () => infoModal.style.display = 'none'
            ,1200);
        return;
    }

    document.getElementById('applicant').classList.remove("hidden");
    modal.classList.remove("hidden");
    document.querySelector('.modal_title_text').innerHTML = `상담 예약 하기`;
    modal.setAttribute("data-id", data.id);
    document.querySelector('#modal_point_title').innerText = `${data.professorName} 교수님`;
    document.querySelector('.modal_point_text').innerHTML = `<span style="text-decoration: underline;">${applicantDate}일</span> : ${data.timeStart} ~ ${data.timeEnd}상담`;
}

const openCancel = (data) => () => {
    document.getElementById('cancel').classList.remove("hidden");
    modal.setAttribute("data-id", data.id);
    document.querySelector('.modal_title_text').innerHTML = `상담 취소 하기`;
    document.querySelector('#modal_point_title').innerText = `${data.professorName} 교수님`;
    document.querySelector('.modal_point_text').innerHTML = `<span style="text-decoration: underline;">${applicantDate}일</span> : ${data.timeStart} ~ ${data.timeEnd}상담을 취소 하시겠습니까?`;
    modal.classList.remove("hidden");
}

const getTimeDiff = (start, end) => {

}
const applicantForm = (data) => {
    //3개 가능 할 때
    const isApplicant = data.id === myApplicantList[0]?.applicantId || data.id === myApplicantList[1]?.applicantId;
    return ( `
    <li class="list-content ${!isApplicant && data.numberOfApplicant >= 3 ? 'end' : ''}" data-is-applicant="${isApplicant}">
        <div class="list-wrapper">
            <div class="list-container">
                <div class="list-box-1">
                    <div class="counseling-from">
                        <span class="counseling-time">${data.timeStart}</span>
                    </div>
                    <div class="counseling-to">
                        <span class="counseling-time">${data.timeEnd}</span>
                    </div>
                </div>
                <div class="list-box-2">
                    <div class="direction">
                        <span class="duration">30분</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="list-main-wrapper ${isApplicant ? 'selected-applicant-list' : ''}">
            <div class="list-main-container">
                <div class="list-main-box">
                    <div class="list-main">
                        <label class="list-main-label">
                            <span class="professor"><span style="font-size: 36px;margin-right: 13px;">${data.professorName}</span> 교수님</span>
                            
                            
                        </label>
                    </div>
                </div>
            </div>
        </div>
    </li>
`)}

const getApplicantData = (majorId, applicantDate) =>
    fetch(`/applicant/get-applicant-data?majorId=${majorId}&applicantDate=${applicantDate}`, {method : 'GET'}).then(response => response.json());


const makeApplicant = async (majorId, applicantDate) => {
    let html = '';
    let data = null;
    await getApplicantData(majorId, applicantDate).then(result => data = result);
    data.forEach(el => html += applicantForm(el));
    if(html === ''){
        html += `<h2 style="color: #a7a7a7; text-align: center; margin-top: 150px">신청 가능한 상담이 없어요...<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 496 512"><path d="M248 8C111 8 0 119 0 256s111 248 248 248 248-111 248-248S385 8 248 8zm0 448c-110.3 0-200-89.7-200-200S137.7 56 248 56s200 89.7 200 200-89.7 200-200 200zm8-152c-13.2 0-24 10.8-24 24s10.8 24 24 24c23.8 0 46.3 10.5 61.6 28.8 8.1 9.8 23.2 11.9 33.8 3.1 10.2-8.5 11.6-23.6 3.1-33.8C330 320.8 294.1 304 256 304zm-88-64c17.7 0 32-14.3 32-32s-14.3-32-32-32-32 14.3-32 32 14.3 32 32 32zm160-64c-17.7 0-32 14.3-32 32s14.3 32 32 32 32-14.3 32-32-14.3-32-32-32zm-165.6 98.8C151 290.1 126 325.4 126 342.9c0 22.7 18.8 41.1 42 41.1s42-18.4 42-41.1c0-17.5-25-52.8-36.4-68.1-2.8-3.7-8.4-3.7-11.2 0z"/></svg></h2>`;
    }
    applicantList.innerHTML = html;
    const applicantContents = document.querySelectorAll('.list-content');

    applicantContents.forEach((applicant, i) => {
        if(applicant.dataset.isApplicant == 'true'){
            applicant.addEventListener('click', openCancel(data[i]));
        }
        if(data[i].numberOfApplicant > 2){return false;}
        if(applicant.dataset.isApplicant == 'false'){
            applicant.addEventListener('click', openApplicant(data[i]));
        }
    });
}


makeApplicant(majorId, applicantDate).catch(reason => console.log(reason));

const isFull = (res) => {
    if(res == null){
        makeInfoModal(infoModal, '#f27474', '<span class="info-modal-icon-left"></span><span class="info-modal-icon-right"></span>', '신청이 완료된 상담입니다.', '다른 상담을 신청해주세요.')
        setTimeout( () => {
            infoModal.style.display = 'none';
            },1500);
    }
    else {
        myApplicantList = res;
    }
    makeApplicant(majorId, applicantDate).catch(reason => console.log(reason));
}

applicantSubmitBtn.addEventListener('click', async function () {

    const applicantId = modal.dataset.id;
    await fetch("/applicant/" + applicantId)
        .then(result => result.json()).then(isFull);
    close();
})

const isSuccess = (res) => {
    if(res == 'null'){
        makeInfoModal(infoModal, '#f27474', '<span class="info-modal-icon-left"></span><span class="info-modal-icon-right"></span>', '알 수 없는 오류가 발생했습니다', '계속 될 경우 대학행정팀에 연락주세요');
        setTimeout( () => infoModal.style.display = 'none'
            ,1500);
        return;
    }
    myApplicantList = res;
    makeInfoModal(infoModal, 'blue', '<span class="info-modal-icon-left-v2"></span><span class="info-modal-icon-right-v2"></span>', '예약 취소를 완료하였습니다.', `가능한 상담 ${2 - myApplicantList.length}개`)
    setTimeout( () => infoModal.style.display = 'none'
        ,1500);
}

cancelSubmitBtn.addEventListener('click', async function () {
    const applicantId = modal.dataset.id;
    await fetch("/applicant/delete/" + applicantId, {method : 'DELETE'})
        .then(result => result.json()).then(isSuccess);
    close();
    makeApplicant(majorId, applicantDate).catch(reason => console.log(reason));
})