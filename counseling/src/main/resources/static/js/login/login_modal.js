const infoModal = document.querySelector('.info-modal');

const makeInfoModal = (modal, borderColor, modalIcon, modalTitle, modalFoot) =>{
    const infoModalBox = document.querySelector('.info-modal-icon-box'),
        infoModalBody = document.querySelector('.info-modal-icon-body'),
        infoModalTitle = document.querySelector('.info-modal-title'),
        infoModalFoot = document.querySelector('.info-modal-foot>div');

    infoModalBox.style.borderColor = borderColor;
    infoModalBody.innerHTML = modalIcon;
    infoModalTitle.innerHTML = modalTitle;
    infoModalFoot.innerText = modalFoot;
    modal.style.display = 'flex';
}


