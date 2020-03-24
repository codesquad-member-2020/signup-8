//
//  ViewController.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/23.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var IDTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var passwordConfirmTextField: UITextField!
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var nextButton: UIButton!
    @IBOutlet var labels: [UILabel]!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setUI()
    }
    
    private func setUI() {
        setBorder(view: IDTextField, color: .gray, width: 1)
        setBorder(view: passwordTextField, color: .gray, width: 1)
        setBorder(view: passwordConfirmTextField, color: .gray, width: 1)
        setBorder(view: nameTextField, color: .gray, width: 1)
        setBorder(view: nextButton, color: .gray, width: 1)
        labels.forEach{
            $0.alpha = 0
        }
    }
    
    private func setBorder(view: UIView, color: UIColor, width: CGFloat) {
        view.layer.borderColor = color.cgColor
        view.layer.borderWidth = width
        guard let textField = view as? UITextField else {return}
        textField.borderStyle = .line
    }
}

