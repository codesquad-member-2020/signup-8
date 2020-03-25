//
//  StatusLabel.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/25.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class StatusLabel: UILabel {
    enum Status: String {
        case LongLength = "ID는 20글자 이하여야 합니다."
        case ShortLength = "ID는 5글자 이상이어야 합니다."
        case InvalidID = "영문 소문자, 숫자, 특수기호(_, -)를 사용해야합니다."
        case DuplicateID = "이미 사용 중인 ID 입니다."
        case OK = "사용 가능한 ID 입니다."
        case Normal
    }
    
    private var status: Status {
        didSet {
            changeText(status: status)
        }
    }
    
    override init(frame: CGRect) {
        status = .Normal
        super.init(frame: frame)
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(isValid(_:)),
                                               name: .isValidID,
                                               object: nil)
    }
    
    required init?(coder: NSCoder) {
        status = .Normal
        super.init(coder: coder)
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(isValid(_:)),
                                               name: .isValidID,
                                               object: nil)
    }
    
    deinit {
        NotificationCenter.default.removeObserver(self)
    }
    
    private func changeText(status: Status) {
        text = status.rawValue
        alpha = 1
        switch status {
        case .DuplicateID,.InvalidID,.LongLength,.ShortLength:
            textColor = .red
        case .Normal:
            textColor = .gray
        case .OK:
            textColor = .systemGreen
        }
    }
    
    @objc func isValid(_ notification: Notification) {
        if let info: [String : Status] = notification.userInfo as? [String : Status] {
            status = info["status"] ?? Status.Normal
        }
    }
}
